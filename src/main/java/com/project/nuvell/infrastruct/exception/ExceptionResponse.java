package com.project.nuvell.infrastruct.exception;

import java.util.Date;

public record ExceptionResponse(Date timeStamp, String message, String details) {}
