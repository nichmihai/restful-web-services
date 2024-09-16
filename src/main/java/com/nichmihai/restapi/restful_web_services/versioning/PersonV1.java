package com.nichmihai.restapi.restful_web_services.versioning;

public class PersonV1 {

    private String name;
    public PersonV1(String personName) {
        this.name = personName;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }
}
