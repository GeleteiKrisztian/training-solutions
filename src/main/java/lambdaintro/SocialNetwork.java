package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {

    private List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public List<Member> findMembersBy(Predicate<Member> memberPredicate) {
        List<Member> res = new ArrayList<>();
        for (Member item : members) {
            if (memberPredicate.test(item)) {
                res.add(item);
            }
        }
        return res;
    }

    public void applyToSelectedMembers(Predicate<Member> memberPredicate, Consumer<Member> memberConsumer) {
        for(Member item : members) {
            if (memberPredicate.test(item)) {
                memberConsumer.accept(item);
            }
        }
    }


    public <T> List<T> transformMembers(Function<Member, T> function) {
        List<T> transformed = new ArrayList<>();
        for (Member member: members) {
            transformed.add(function.apply(member));
        }
        return transformed;
    }
}
