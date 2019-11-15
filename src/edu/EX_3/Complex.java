package edu.EX_3;

/**
 * Complex
 */
public class Complex{
/**
 * @see #add(Complex)
 * @see #reduce(Complex)
 * @see #ride(Complex)
 */
    private float realPart;
    private float imagePart;

    public float getRealPart(){
        return this.realPart;
    }
    public float getImagePart(){
        return this.imagePart;
    }

    public Complex(){}
    public Complex(float realPart,float imagePart){
        this.imagePart = imagePart;
        this.realPart = realPart;
    }

    public Complex add(Complex otherComplex){
        return new Complex(this.getRealPart()+otherComplex.getRealPart(),this.getImagePart()+otherComplex.getImagePart());
    }

    public Complex reduce(Complex otherComplex){
        return new Complex(this.getRealPart()-otherComplex.getRealPart(),this.getImagePart()-otherComplex.getImagePart());
    }
    
    public Complex ride(Complex otherComplex){
        float a = this.getRealPart();
        float b = this.getImagePart();
        float c = otherComplex.getRealPart();
        float d = otherComplex.getImagePart();
        return new Complex((a*c-b*d),(b*c+a*d));
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.realPart);
        sb.append(this.imagePart);
        sb.append(")");
        return sb.toString();
    }
}

