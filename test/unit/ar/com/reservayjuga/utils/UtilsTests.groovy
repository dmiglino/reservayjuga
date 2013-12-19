package ar.com.reservayjuga.utils

import grails.test.mixin.*
import grails.test.mixin.support.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class UtilsTests {

    void testCrearFechaByString() {
		Date fechaCreada = Utils.crearFechaByString("1-1-2014")
		Calendar cal = Calendar.getInstance()
		cal.setTime(fechaCreada)
		assertEquals 2014, cal.get(Calendar.YEAR)
		assertEquals 1, cal.get(Calendar.MONTH)+1 // los meses van de 0 a 11
		assertEquals 1, cal.get(Calendar.DATE)
    }
	
	void testGetDayOfWeek() {
		assertEquals 4, Utils.getDayOfWeek("1-1-2014")
		assertEquals 4, Utils.getDayOfWeek("8-1-2014")
		assertEquals 5, Utils.getDayOfWeek("9-1-2014")
		assertEquals 6, Utils.getDayOfWeek("10-1-2014")
		assertEquals 7, Utils.getDayOfWeek("11-1-2014")
		assertEquals 1, Utils.getDayOfWeek("12-1-2014")
	}
	
	void testOnlyNumbers() {
		assertTrue Utils.onlyNumbers(123123)
		assertTrue Utils.onlyNumbers("123123")
		assertFalse Utils.onlyNumbers("asd")
		assertFalse Utils.onlyNumbers("123asd")
		assertFalse Utils.onlyNumbers("asd123")
	}
	
	void testIsMail() {
		assertTrue Utils.isMail("diego@mail.com")
		assertFalse Utils.isMail("diego@mail")
		assertFalse Utils.isMail("diegomail")
		assertFalse Utils.isMail(123123)
	}
}