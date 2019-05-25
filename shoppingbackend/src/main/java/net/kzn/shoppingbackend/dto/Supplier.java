
package net.kzn.shoppingbackend.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Component
@Entity
public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// private fields
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String code;
		@NotBlank(message = "Please enter the supplier name!")
		private String name;
		@NotBlank(message = "Please enter the company name!")
		private String company;
		@NotBlank(message = "Please enter the company address!")
		private String address;
		@NotBlank(message = "Please enter the contact number!")
		private int number;
		@NotBlank(message = "Please enter the email address!")
		private String email;
		@Column(name = "is_active")	
		private boolean active;
		@Column(name = "supplier_id")
		@JsonIgnore
		private int supplierId;
		
		
		@Transient
		private MultipartFile file;
		
		// default constructor
		public Supplier() {
			
			this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
			
		}
		
				
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public int getSupplierId() {
			return supplierId;
		}

		public void setSupplierId(int supplierId) {
			this.supplierId = supplierId;
		}

		public MultipartFile getFile() {
			return file;
		}

		public void setFile(MultipartFile file) {
			this.file = file;
		}
		

		public String getCode() {
			return code;
		}


		public void setCode(String code) {
			this.code = code;
		}


		@Override
		public String toString() {
			return "Supplier [id=" + id + ", code=" + code + ", name=" + name + ", company=" + company + ", address="
					+ address + ", number=" + number + ", email=" + email + ", active=" + active + ", supplierId="
					+ supplierId + ", file=" + file + "]";
		}


	




}
