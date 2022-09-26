package upeu.edu.pe.pybiblioteca.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import upeu.edu.pe.pybiblioteca.dao.Operaciones;
import upeu.edu.pe.pybiblioteca.entity.Prestamo;
import upeu.edu.pe.pybiblioteca.entity.Empleado;
import upeu.edu.pe.pybiblioteca.entity.Alumno;
import upeu.edu.pe.pybiblioteca.entity.Detalle;
@Component

public class PrestamoDaoImpl implements Operaciones<Prestamo> {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Prestamo t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO (fecha_prestamo, fecha_devolucion, idempleado, idalumno) VALUES(?,?,?,?)";
		return jdbcTemplate.update(SQL, t.getFecha_prestamo(), t.getFecha_devolucion(), t.getIdempleado(), t.getIdalumno());
	}
 
	@Override
	public int update(Prestamo t) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE prestamo SET fecha_prestamo, fecha_devolucion = ? WHERE (idprestamo = ?)";
		return jdbcTemplate.update(SQL, t.getIdprestamo());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM prestamo WHERE idprestamo=?";
		return jdbcTemplate.update(SQL, id);
	}

	@Override
	public Prestamo read(int id) {
		// TODO Auto-generated method stub
		try {
			Prestamo pres = jdbcTemplate.queryForObject("SELECT * FROM prestamo WHERE idprestamo=?",
					BeanPropertyRowMapper.newInstance(Prestamo.class), id);
			return pres;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}

	}

	@Override
	public List<Prestamo> reaAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * from prestamo", BeanPropertyRowMapper.newInstance(Prestamo.class));
	}

	@Override
	public List<Map<String, Object>> readAll2() {
		// TODO Auto-generated method stub
		String SQL = "select a.idalumno, e.idempleado, t.fecha_prestamo, t.fecha_devolucion from detalle as t "
				+ "inner join alumno as a on t.idalumno= a.idalumno "
				+ "inner join empleado as e on t.idlibro= e.idlibro ";
		return jdbcTemplate.queryForList(SQL);
	}

}
