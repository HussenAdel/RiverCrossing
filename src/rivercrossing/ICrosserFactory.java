package rivercrossing;


public class ICrosserFactory {

	public ICrosser makeICrosser(String s,double weight) {

		if (s.equals("Farmer"))
			return new Farmer(weight);

		if (s.equals("Wolf"))
			return new Wolf(weight);

		if (s.equals("Lion"))
			return new Lion(weight);
                
		if (s.equals("Herbivorous"))
			return new Herbivorous(weight);

		if (s.equals("Plant"))
			return new Plant(weight);

		return null;
	}
}
