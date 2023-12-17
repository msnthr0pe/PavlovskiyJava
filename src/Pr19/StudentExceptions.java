package Pr19;

class EmptyStringException extends Exception{
    public EmptyStringException(String message) {
        super(message);
    }
}

class NotFoundStudentException extends Exception{
    public NotFoundStudentException(String message) {
        super(message);
    }
}