package com.bank.system.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="account")
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
        @Column 
        @Size(min = 10, max = 10, message= "Account Number Must of Size 10")
        @Pattern(regexp="[^A-Z,^a-z,?<>]*",message = "Alphabetic value,?,<,> as Account Number is not allowed")
        @NotEmpty(message = "Account Number name must not be empty")
        private String accountNumber;
        @Column
        @NotEmpty(message = "IFSC must not be empty")
        private String ifscCode;
        @Column
        @Pattern(regexp="[^0-9,?<>]*",message = "Numeric value,?,<,> as bank name is not allowed")
        @NotEmpty(message = "ACCOUNT name must not be empty")
       private String accountName;
        @Column
        private String micrCode;
        @Column
        @NotEmpty(message = "PAN must not be empty")
        private String pan;

       // @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")  

		public String getPan() {
			return pan;
		}

		public void setPan(String pan) {
			this.pan = pan;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getIfscCode() {
			return ifscCode;
		}

		public void setIfscCode(String ifscCode) {
			this.ifscCode = ifscCode;
		}

		public String getAccountName() {
		return accountName;
	}

		public void setAccountName(String accountName) {
		this.accountName = accountName;
		}

		public String getMicrCode() {
			return micrCode;
		}

		public void setMicrCode(String micrCode) {
			this.micrCode = micrCode;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Account(long id,
				@Size(min = 10, max = 10, message = "Account Number Must of Size 10") @Pattern(regexp = "[^A-Z,^a-z,?<>]*", message = "Alphabetic value,?,<,> as Account Number is not allowed") @NotEmpty(message = "Account Number name must not be empty") String accountNumber,
				@NotEmpty(message = "IFSC must not be empty") String ifscCode,
				@Pattern(regexp = "[^0-9,?<>]*", message = "Numeric value,?,<,> as bank name is not allowed") @NotEmpty(message = "ACCOUNT name must not be empty") String accountName,
				String micrCode, @NotEmpty(message = "PAN must not be empty") String pan) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.ifscCode = ifscCode;
			this.accountName = accountName;
			this.micrCode = micrCode;
			this.pan = pan;
		}

		@Override
		public String toString() {
			return "Account [id=" + id + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode
					+ ", accountName=" + accountName + ", micrCode=" + micrCode + ", pan=" + pan + "]";
		}

		public Account() {
			super();
		}

	
	    
	
}
