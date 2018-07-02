/**
 * Copyright (c) 2000-2018 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.test.alloy.showcase.datatable;

import java.util.Date;


/**
 * @author  Neil Griffin
 */
public class Customer {

	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	public Customer(String firstName, String lastName, Date dateOfBirth) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public boolean equals(Object obj) {

		Customer otherCustomer = (Customer) obj;

		return getFirstName().equals(otherCustomer.getFirstName()) &&
			getLastName().equals(otherCustomer.getLastName()) &&
			getDateOfBirth().equals(otherCustomer.getDateOfBirth());
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
