/**
 *
 * Copyright © 2014 Florian Schmaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jxmpp.jid.parts;

public abstract class Part implements CharSequence {

	private final String part;

	protected Part(String part) {
		this.part = part;
	}

	@Override
	public final int length() {
		return part.length();
	}

	@Override
	public final char charAt(int index) {
		return part.charAt(index);
	}

	@Override
	public final CharSequence subSequence(int start, int end) {
		return part.subSequence(start, end);
	}

	@Override
	public final String toString() {
		return part;
	}

	@Override
	public final boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		return part.equals(other.toString());
	}

	@Override
	public final int hashCode() {
		return part.hashCode();
	}

	protected static void assertNotLongerThen1023BytesOrEmpty(String string) {
		char[] bytes = string.toCharArray();
		if (bytes.length > 1023) {
			throw new IllegalArgumentException("Given string '" + string + "' is longer then 1023 bytes");
		} else if (bytes.length == 0) {
			throw new IllegalArgumentException("Argument can't be the empty string");
		}
	}
}
