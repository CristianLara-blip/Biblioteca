package upeu.edu.pe.pybiblioteca.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.pybiblioteca.dao.Operaciones;
import upeu.edu.pe.pybiblioteca.daoImpl.PrestamoDaoImpl;
import upeu.edu.pe.pybiblioteca.entity.Prestamo;
@Service
public class PrestamoService implements Operaciones<Prestamo> {
	
	@Autowired
	private PrestamoDaoImpl daqoImpl;

	@Override
	public int create(Prestamo t) {
		// TODO Auto-generated method stub
		return daqoImpl.create(t);
	}

	@Override
	public int update(Prestamo t) {
		// TODO Auto-generated method stub
		return daqoImpl.update(t);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return daqoImpl.delete(id);
	}

	@Override
	public Prestamo read(int id) {
		// TODO Auto-generated method stub
		return daqoImpl.read(id);
	}

	@Override
	public List<Prestamo> reaAll() {
		// TODO Auto-generated method stub
		return daqoImpl.reaAll();
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
