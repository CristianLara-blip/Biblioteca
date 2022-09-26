package upeu.edu.pe.pybiblioteca.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.pybiblioteca.dao.Operaciones;
import upeu.edu.pe.pybiblioteca.entity.Empleado;

public class EmpleadoDaoImpl implements Operaciones<Empleado> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Empleado t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO empleado(usuario, clave, estado) VALUES(now())";
		return jdbcTemplate.update(SQL);
	}

	@Override
	public int update(Empleado t) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE empleado SET usuario, clave, estado = ? WHERE idempleado=?";
		return jdbcTemplate.update(SQL, t.getUsuario(), t.getClave(), t.getEstado(), t.getIdempleado());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM empleado WHERE idempleado=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Empleado read(int id) {
		// TODO Auto-generated method stub
		try {
			Empleado em = jdbcTemplate.queryForObject("SELECT * FROM empleado WHERE idempleado=?",
					BeanPropertyRowMapper.newInstance(Empleado.class), id);
			return em;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Empleado> reaAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from empleado", BeanPropertyRowMapper.newInstance(Empleado.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
