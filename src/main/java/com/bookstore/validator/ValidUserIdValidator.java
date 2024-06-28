package com.bookstore.validator;

import com.bookstore.entity.User;
import com.bookstore.repository.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, Integer> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public  boolean isValid(Integer userid, ConstraintValidatorContext constraintValidatorContext){
        if(userid == null)
            return true;
        User user = userRepository.findById(userid).orElse(null);
        return user != null;
    }
}
