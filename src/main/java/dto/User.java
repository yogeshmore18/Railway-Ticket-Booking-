package dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class User
{
	@Id
	@GeneratedValue(generator="x")
	@SequenceGenerator(name="x", sequenceName="x", initialValue=1214561,allocationSize=1)
	int Id;
	String First_Name;
	String Last_Name;
	long Mobile_Number;
	@Column(nullable=false, unique=true)
	String Email_ID;
	String Gender;
	Date Date_Of_Birth;
	String Address;
	@Column(nullable=false, unique=true)
	String Create_Password;
	String Confirm_Password;
	int Age;
	double Wallet;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public long getMobile_Number() {
		return Mobile_Number;
	}
	public void setMobile_Number(long mobile_Number) {
		Mobile_Number = mobile_Number;
	}
	public String getEmail_ID() {
		return Email_ID;
	}
	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getDate_Of_Birth() {
		return Date_Of_Birth;
	}
	public void setDate_Of_Birth(Date date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCreate_Password() {
		return Create_Password;
	}
	public void setCreate_Password(String create_Password) {
		Create_Password = create_Password;
	}
	public String getConfirm_Password() {
		return Confirm_Password;
	}
	public void setConfirm_Password(String confirm_Password) {
		Confirm_Password = confirm_Password;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public double getWallet() {
		return Wallet;
	}
	public void setWallet(double wallet) {
		Wallet = wallet;
	}
	
	
	
}
