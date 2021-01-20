package lambdaoptional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public Optional<Member> findFirst(Predicate<Member> memberPredicate) {
        for (Member item : members) {
            if (memberPredicate.test(item)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> averageNumberOfSkills() {
        if (members.size() == 0){
            return Optional.empty();
        }
        int skillsCounter = 0;
        for (Member item : members) {
            skillsCounter += item.getSkills().size();
        }
        return Optional.of((double) skillsCounter / members.size());
    }

}
