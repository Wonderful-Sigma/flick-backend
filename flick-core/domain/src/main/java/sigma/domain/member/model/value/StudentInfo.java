package sigma.domain.member.model.value;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class StudentInfo {

    private String number;
    private String name;

    public String number() {
        return number;
    }

    public String name() {
        return name;
    }

}