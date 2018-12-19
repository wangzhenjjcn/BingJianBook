package com.bingjian.book.domain.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bingjian.book.domain.UserCreateForm;
import com.bingjian.book.service.UserService;

/**
 * @author Myazure
 */
@Component
public class UserCreateFormValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserCreateFormValidator(UserService userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> clazz) {
        return clazz.equals(UserCreateForm.class);
    }

    public void validate(Object target, Errors errors) {
        UserCreateForm form = (UserCreateForm) target;
        validatePasswords(errors, form);
        validateName(errors, form);
    }

    private void validatePasswords(Errors errors, UserCreateForm form) {
        if (!form.getPassword().equals(form.getPasswordRepeated())) {
            errors.rejectValue("password", "password", "Passwords do not match");
        }
    }

    private void validateName(Errors errors, UserCreateForm form) {
        if (userService.getUserByName(form.getUserName()) != null) {
            errors.rejectValue("userName", "userName", "User with this name already exists");
        }
    }
}
