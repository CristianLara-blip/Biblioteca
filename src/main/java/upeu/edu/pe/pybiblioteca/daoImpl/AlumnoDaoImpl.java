package upeu.edu.pe.pybiblioteca.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.pybiblioteca.dao.Operaciones;
import upeu.edu.pe.pybiblioteca.entity.Alumno;
@Component
public class AlumnoDaoImpl implements Operaciones<Alumno> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Alumno t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO alumno(codigo, nombre, apellidos) VALUES(now())";
		return jdbcTemplate.update(SQL);
	}

	@Override
	public int update(Alumno t) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE alumno SET codigo, nombre, apellidos = ? WHERE idalumno=?";
		return jdbcTemplate.update(SQL, t.getCodigo(), t.getNombre(), t.getApellidos(), t.getIdalumno());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM alumno WHERE idalumno=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Alumno read(int id) {
		// TODO Auto-generated method stub
		try {
			Alumno alu = jdbcTemplate.queryForObject("SELECT * FROM alumno WHERE idalumno=?",
					BeanPropertyRowMapper.newInstance(Alumno.class), id);
			return alu;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Alumno> reaAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from alumno", BeanPropertyRowMapper.newInstance(Alumno.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		return null;
	}

}
