package com.LocationApplications.Entity;
import java.io.Serializable;
import java.util.Objects;

public class LdapPK implements Serializable {
    private String user;

    public LdapPK() {}

    public LdapPK(String user) {
        this.user = user;
    }

    // equals and hashcode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LdapPK)) return false;
        LdapPK that = (LdapPK) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
