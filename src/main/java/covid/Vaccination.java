package covid;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Vaccination {

    private List<Citizen> citizens;

    public void startVaccinateCitizen() {
        ReadFromConsole rfc = new ReadFromConsole();
        String zip = rfc.readZip();
        citizens = new Generation().readFirst16CitizenToVaccinate(zip);
        if (citizens.size() == 0) {
            System.out.println("Gratulálunk! Nincs olyan,akit be lehetne oltani ezen az irányítószámon...MÉG!\n");
            return;
        }
        String taj = rfc.readTaj();
        Citizen citizen = findCitizenByTaj(taj);
        doVaccination(citizen);
    }

    private void updateCitizenVaccinationCounter(Citizen citizen) {
        try (PreparedStatement preparedStatement =
                     new TbdDAO().getDs().getConnection().prepareStatement("UPDATE `citizens` SET number_of_vaccination = number_of_vaccination + 1, last_vaccination = NOW() WHERE citizen_id = ?")) {
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new IllegalStateException("DB error. Can't update citizen vaccination number.", sqlException);
        }
    }

    public Citizen findCitizenByTaj(String taj) {
        for (Citizen item : citizens) {
            if (item.getTajId().equals(taj) && new Validator().isContainsDbTaj(taj)) {
                System.out.println(item.getFullName());
                return item;
            }
        }
        throw new IllegalStateException("No citizen with TAJ: " + taj);
    }


    private void doVaccination(Citizen citizen) {
        try (Connection connection = new TbdDAO().getDs().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vaccinations (citizen_id_f, vaccination_date, `status`, note, vaccination_type) VALUES (?, ?, ?, ?, ?)")) {
            LocalDateTime dateTime = LocalDateTime.now();
            VaccineType vaccineType;
            if (citizen.getNumberOfVaccination() == 0) {
                vaccineType = chooseVaccineMenu();
            } else {
                vaccineType = citizen.getVaccineType();
                System.out.println(citizen.getVaccineType().toString());
            }
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(dateTime));
            preparedStatement.setString(3, Status.values()[citizen.getNumberOfVaccination() + 1].toString());
           String desc = new ReadFromConsole().readDescription();
            preparedStatement.setString(4, desc + "\n");
            preparedStatement.setString(5, vaccineType.toString());
            preparedStatement.executeUpdate();
            updateCitizenVaccinationCounter(citizen);
            System.out.println("Sikeres beoltás.\n");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can't vaccinate ciziten. DB error.", sqlException);
        }
    }

    private VaccineType chooseVaccineMenu() {
        int item = -1;
        VaccineType[] vaccineTypes = VaccineType.values();
        try {
            System.out.println("Válassz vakcina típust: ");
            while (item != 0) {
                for (int i = 0; i < vaccineTypes.length; i++) {
                    System.out.println(i + 1 + ". " + vaccineTypes[i].toString());
                }
                System.out.println(0 + ". Kilépés");
                System.out.print("\nVálassz menüpontot: ");
                Scanner scanner = new Scanner(System.in);
                item = Integer.parseInt(scanner.nextLine());
                if (item < 0 || item > vaccineTypes.length) {
                    throw new IllegalMenuItemException("Hibás szám.");
                }
                if (item == 0) {
                    System.out.println("Köszönjük!");
                    break;
                }
                System.out.println("\nKiválasztott vakcina típus: " + vaccineTypes[item - 1].toString());
                return vaccineTypes[item - 1];
            }
        } catch (NumberFormatException | IllegalMenuItemException e) {
            System.out.println("Hibás adatbevitel. Kérlek válassz újra: \n");
            chooseVaccineMenu();
        }
        return null;
    }

    public void excludeCitizenFromVaccination() {
        String taj = new ReadFromConsole().readTaj();
            Citizen citizen = queryCitizenByTaj(taj);
            try (Connection connection = new TbdDAO().getDs().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vaccinations (citizen_id_f, vaccination_date, `status`, note, vaccination_type) VALUES (?, ?, ?, ?, ?)")) {
preparedStatement.setInt(1, citizen.getId());
preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
preparedStatement.setString(3, Status.REJECTED.toString());
                String desc = new ReadFromConsole().readDescription();
                preparedStatement.setString(4, desc);
                preparedStatement.setString(5, null);
                preparedStatement.executeQuery();
                System.out.println("Oltás elutasításának regisztrációja sikerült.\n");
            } catch (SQLException sqlException) {
                throw new IllegalStateException("Oltás elutasításának regisztrációja sikertelen.", sqlException);
            }
    }

    private Citizen queryCitizenByTaj(String taj) {
        if (!isCitizenRejected(taj)) {
            try (Connection connection = new TbdDAO().getDs().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM citizens WHERE taj = ?")) {
                preparedStatement.setString(1, taj);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    int id = res.getInt(1);
                    String name = res.getString(2);
                    String zip = res.getString(3);
                    byte age = res.getByte(4);
                    String email = res.getString(5);
                    String tajId = res.getString(6);
                    byte numOfVaccination = -1;
                    LocalDateTime dateTime = Timestamp.valueOf(res.getString(8)).toLocalDateTime();
                    Citizen citizen = new Citizen(id, name, zip, age, email, tajId, numOfVaccination, dateTime);
                    return citizen;
                }
            } catch (SQLException sqlException) {
                throw new IllegalStateException("DB error.", sqlException);
            }
        }
        throw new IllegalStateException("Citizen already rejected.");
    }

    private boolean isCitizenRejected(String taj) {
        try (Connection connection = new TbdDAO().getDs().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM citizens LEFT JOIN vaccinations ON citizen_id = vaccinations.citizen_id_f WHERE taj = ? AND status = 'REJECTED'")) {
            preparedStatement.setString(1, taj);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                return true;
            }
            return false;
        }
             catch (SQLException sqlException) {
                throw new IllegalStateException("DB error.", sqlException);
            }
    }
}

