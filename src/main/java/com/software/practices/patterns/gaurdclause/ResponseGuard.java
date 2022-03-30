package com.software.practices.patterns.gaurdclause;

import lombok.extern.log4j.Log4j;

import java.util.Objects;

/**
 * @author Sagar Kanojia
 */
public class ResponseGuard {

    public static void AgainstNull(Object argument, String argumentName) throws CustomException {

        if (Objects.isNull(argument)) {
            throw new CustomException(argumentName);
        }
    }

    public static void AgainstFailedResponse(Response argument, String argumentName) throws CustomException {

        AgainstNull(argument, argumentName);

        if (Objects.isNull(argument.getStatus()) || Objects.equals(ReesponseStatus.FAILED.name(), argument.getStatus())) {
            throw new CustomException(argumentName);
        }

    }
}
