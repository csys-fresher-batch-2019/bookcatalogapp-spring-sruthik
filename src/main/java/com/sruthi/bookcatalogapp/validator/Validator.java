package com.sruthi.bookcatalogapp.validator;

import com.sruthi.bookcatalogapp.domain.Author;
import com.sruthi.bookcatalogapp.domain.Publisher;
import com.sruthi.bookcatalogapp.domain.Title;
import com.sruthi.bookcatalogapp.domain.Users;
import com.sruthi.bookcatalogapp.exception.ValidatorException;

public class Validator {

	public static void validateRegisterForm(Users u) throws ValidatorException {

		if (u.getUserName() == null || "".equals(u.getUserName().trim())) {

			throw new ValidatorException("Name cannot be blank/empty");

		}
		if (u.getUserMailId() == null || "".equals(u.getUserMailId().trim())) {

			throw new ValidatorException("Mail-id cannot be blank/empty");

		}
		if (u.getSetPassword() == null || "".equals(u.getSetPassword().trim())) {

			throw new ValidatorException("Password cannot be blank/empty");

		}
		if (u.getConfirmPassword() == null || "".equals(u.getConfirmPassword().trim())) {

			throw new ValidatorException("Confirm your password");

		}
		if (u.getPhNo() == 0) {

			throw new ValidatorException("Phone-number cannot be blank/empty");

		}
		if (u.getSetPassword().equals(u.getConfirmPassword())) {
			throw new ValidatorException("Password Mismatch!!");
		}

	}
	public static void validatePublisher(Publisher p) throws ValidatorException{
		if(p.getName() == null ||"".equals(p.getName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if(p.getMailId() == null ||"".equals(p.getMailId().trim())) {
			throw new ValidatorException("Mail-Id cannot be blank/empty");
		}
		if(p.getPhoneNumber() == 0) {
			throw new ValidatorException("Phone-Number cannot be blank/empty");
		}
	}
	public static void validateAuthor(Author a) throws ValidatorException{
		if(a.getName() == null ||"".equals(a.getName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if(a.getMailId() == null ||"".equals(a.getMailId().trim())) {
			throw new ValidatorException("Mail-Id cannot be blank/empty");
		}
		if(a.getPhoneNumber() == 0) {
			throw new ValidatorException("Phone-Number cannot be blank/empty");
		}
	}
	public static void validateTitle(Title t) throws ValidatorException{
		if(t.getTitleName() == null ||"".equals(t.getTitleName().trim())) {
			throw new ValidatorException("Name cannot be blank/empty");
		}
		if(t.getAuthorId() == 0) {
			throw new ValidatorException("AuthorId is empty");
		}
		if(t.getPublisherId() == 0) {
			throw new ValidatorException("PublisherId is empty");
		}
		if(t.getSubjectId()== 0) {
			throw new ValidatorException("SubjectId is empty");
		}
		if(t.getVersionNumber() == 0) {
			throw new ValidatorException("Version is empty");
		}
		if(t.getPublishedDate()==null){
			throw new ValidatorException("Published-Date is empty");
		}
		
	}
   
}
