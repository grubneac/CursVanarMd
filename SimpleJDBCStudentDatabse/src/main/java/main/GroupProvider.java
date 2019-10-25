package main;

import java.util.ArrayList;
import java.util.Locale;

import com.github.javafaker.Faker;

import data.Group;

public class GroupProvider {
	public Group provideOneGroup() {
		Group group = new Group();
		Faker  faker = new Faker(new Locale("ru"));
		group.setCode(faker.code().ean8());
		group.setName(faker.company().name());
		return group;
	}
	
	public ArrayList<Group> provideManyGroups(int quantity){
		ArrayList<Group> groups = new ArrayList<>();
		for(int i=0;i< quantity; i++)groups.add(provideOneGroup());
		return groups;
	}
}
