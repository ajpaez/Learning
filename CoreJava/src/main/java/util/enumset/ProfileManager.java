package util.enumset;

import java.util.EnumSet;

public class ProfileManager {
	public static void printOperationForCustomRole(EnumSet<Role> roles) {
		EnumSet<Operation> mergeSet = EnumSet.noneOf(Operation.class);
		for (Role role : roles) {
			for (Operation op : role.operationSet)
				mergeSet.add(op);
		}
		System.out.println(mergeSet);
	}

	public static void main(String[] args) {
		ProfileManager.printOperationForCustomRole(EnumSet.of(Role.FRIEND, Role.GUEST));
	}
}
