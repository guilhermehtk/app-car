package control;

import java.util.ArrayList;
import model.Carro;
import model.dao.CarroDao;

public class CarroController implements InterfaceControllerCrud {

    CarroDao carDao = new CarroDao();

    @Override
    public int add(Object car) {
        return carDao.add((Carro) car);
    }

    @Override
    public void remove(int id) {
        carDao.remove(id);
    }

    @Override
    public void altera(Object car) {
        Carro carro = (Carro) car;
        carDao.altera(car);
    }

    @Override
    public Object get(int id) {
        return carDao.get(id);
    }

    @Override
    public ArrayList getAll() {
        return carDao.getAll();
    }

    @Override
    public ArrayList<String> valida(Object carro) {
        Carro car = (Carro) carro;
        ArrayList<String> erros = new ArrayList();
        if (car.getMarca().isEmpty()) {
            erros.add("Marca");
        }
        if (car.getModelo().isEmpty()) {
            erros.add("Modelo");
        }
        if (car.getPlaca().isEmpty()) {
            erros.add("Placa");
        }

        return erros;
    }

    public ArrayList<Carro> procurar(String input, int tipo) {
        ArrayList<Carro> arrayCarro = new ArrayList();
        switch (tipo) {
            case 0:
                // Código
                for (Carro carro : carDao.getAll()) {
                    if (carro.getCod() == Integer.valueOf(input)) {
                        arrayCarro.add(carro);
                    }
                }
                return arrayCarro;
            case 1:
                // Placa
                return carDao.getPlaca(input);
            case 2:
                // Chassi
                return carDao.getChassi(input);
            case 3:
                // Dono
              return carDao.getDono(input);
        }
        return null;
        
    }
}
