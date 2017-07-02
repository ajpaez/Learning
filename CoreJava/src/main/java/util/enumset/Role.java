package util.enumset;

import java.util.EnumSet;

public enum Role {
	SELF(EnumSet.of(Operation.VIEW_PROFILE, Operation.VIEW_ALBUM, Operation.EDIT_PROFILE, Operation.EDIT_ALBUM,
			Operation.DELETE_PROFILE, Operation.DELETE_ALBUM, Operation.COMMENT)), FRIEND(
					EnumSet.of(Operation.VIEW_ALBUM, Operation.VIEW_PROFILE, Operation.COMMENT)), GUEST(
							EnumSet.of(Operation.VIEW_PROFILE, Operation.RATE_PROFILE));
	EnumSet<Operation> operationSet;

	Role(EnumSet<Operation> operationSet) {
		this.operationSet = operationSet;
	}
}
