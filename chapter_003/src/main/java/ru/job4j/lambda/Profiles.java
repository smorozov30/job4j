package ru.job4j.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
    public List<Address> getUniqueList(List<Profile> profiles) {
        List<Address> list = this.collect(profiles).stream().distinct().collect(Collectors.toList());
        list.sort(Comparator.comparing(Address::getCity));
        return list;
    }
}