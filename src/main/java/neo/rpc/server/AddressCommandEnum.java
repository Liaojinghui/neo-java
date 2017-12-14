package neo.rpc.server;

import org.json.JSONArray;

/**
 * an enumeration of all the commands that can be sent to the neo core rpc
 * service.
 * <p>
 * https://github.com/neo-project/neo/wiki/API-Reference
 *
 * @author coranos
 *
 */
public enum AddressCommandEnum {
	/** address/balance. */
	BALANCE("/address/balance/"),
	/** address/history. */
	HISTORY("/address/history/"),
	/** address/claims. */
	CLAIMS("/address/claims/"),
	/** unknown. */
	UNKNOWN(""),
	/** */
	;
	/** trailing semicolon */
	;

	/**
	 * returns a command with th given name.
	 *
	 * @param name
	 *            the name to look up.
	 *
	 * @return the command with the given name, or null if no command exists.
	 */
	public static final AddressCommandEnum fromName(final String name) {
		for (final AddressCommandEnum command : values()) {
			if (command != UNKNOWN) {
				if (command.name.equals(name)) {
					return command;
				}
			}
		}
		return UNKNOWN;
	}

	/**
	 * return the values, as a JSON array.
	 *
	 * @return the values, as a JSON array.
	 */
	public static JSONArray getValuesJSONArray() {
		final JSONArray expectedArray = new JSONArray();
		for (final AddressCommandEnum command : AddressCommandEnum.values()) {
			if (command != UNKNOWN) {
				expectedArray.put(command.getName());
			}
		}
		return expectedArray;
	}

	/**
	 * the command name.
	 */
	private final String name;

	/**
	 * the constructor.
	 *
	 * @param name
	 *            the name to use.
	 */
	AddressCommandEnum(final String name) {
		this.name = name;
	}

	/**
	 * returns the name.
	 *
	 * @return the name.
	 */
	public String getName() {
		return name;
	}
}
