package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

	public static final class Constants {
		public static final String SNA = "Server is not accessible for now.";
		public static final String UNA = "User is not authorized.";
		public static final String UB = "User is banned.";
		public static final String AD = "Access is denied.";
	}

	public class ServerNotAccessibleException extends Exception {
		public ServerNotAccessibleException() {
			super(Constants.SNA);
		}

		public ServerNotAccessibleException(Throwable cause) {
			super(Constants.SNA, cause);
		}
	}

	public class UnauthorizedUserException extends Exception {
		public UnauthorizedUserException() {
			super(Constants.UNA);
		}

		public UnauthorizedUserException(Throwable cause) {
			super(Constants.UNA, cause);
		}
	}

	public class BannedUserException extends Exception {
		public BannedUserException() {
			super(Constants.UB);
		}

		public BannedUserException(Throwable cause) {
			super(Constants.UB, cause);
		}
	}

	public class RestrictionException extends Exception {
		public RestrictionException() {
			super(Constants.AD);
		}

		public RestrictionException(Throwable cause) {
			super(Constants.AD, cause);
		}
	}
}