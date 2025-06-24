package com.project.nuvell.infra.exception;

import java.util.Date;

public record ExceptionResponse(Date timeStamp ,String message, String details) {}
