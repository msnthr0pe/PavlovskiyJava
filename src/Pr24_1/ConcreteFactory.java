package Pr24_1;

class ConcreteFactory implements ComplexAbstractFactory {
    @Override
    public Complex createComplex() {
        return new Complex(0, 0);
    }

    @Override
    public Complex createComplex(int real, int imaginary) {
        return new Complex(real, imaginary);
    }
}