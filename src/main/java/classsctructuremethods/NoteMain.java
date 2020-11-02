package classsctructuremethods;

import java.util.Scanner;

public class NoteMain {

    public static void main(String[] args) {
        Note note = new Note();
        //Nem használtam szándékosan Scanner osztályt! A cél ennek a témának a megértése
        note.setName("Geletei Krisztián");
        note.setTopic("Java alapok");
        note.setText("Minden nap 10 órakor megbeszélés!");

        System.out.println(note.getNoteText());
    }
}
