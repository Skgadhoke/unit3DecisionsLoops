import java.util.Scanner;
public class Specturm
{
  
    public Specturm()
    {
       
    }

    public void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter in wavelength value");
        double value=s.nextDouble();
        
        double radio = Math.exp(-1);    
        double micro = Math.exp(-3);
        double infra = 7 * Math.exp(-7);
        double vis = 4 * Math.exp(-7);
        double ultra = Math.exp(-8);
        double xRay = Math.exp(-11);
        double gamma = Math.exp(-11);
        
        if (value < radio)
        {
            System.out.println("Radio Waves");
        }
        else if (value >= radio && value < micro)
        {
            System.out.println("Microwaves");
        }
        else if(value >= micro && value < infra)
        {
            System.out.println("Infrared");
        }
        else if(value >= infra && value < vis)
        {
            System.out.println("Infrared");
        }
        else if(value >= vis && value < ultra)
        {
            System.out.println("Infrared");
        }
        else if(value >= ultra && value < xRay)
        {
            System.out.println("Infrared");
        }
        else
        {
            System.out.println("Gamma Rays");
        }
    }

}
