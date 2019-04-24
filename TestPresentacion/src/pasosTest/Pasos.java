package pasosTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import espera.JQueryWait;
import gestionDatos.ConfigFileReader;
import managers.FileReaderManager;
import managers.WebDriverManager;
import clasesRepresentacionDatos.Cliente;

public class Pasos {
	static WebDriver driver = null;
	WebDriverManager driverManager;
	ConfigFileReader configFileReader;
	long ini;

	@Given("^Cargar driver y configuracion$")
	public void cargar_driver_y_configuracion() throws Throwable {
		configFileReader = new ConfigFileReader();
		driverManager = new WebDriverManager();

		System.setProperty("webdriver.chrome.driver",
				FileReaderManager.getInstance().getConfigReader().getDriverPath());

		driver = driverManager.getDriver();
	}

	@Given("^Verificar que estamos en BlazeDemo$")
	public void verificar_que_estamos_en_BlazeDemo() throws Throwable {
		JQueryWait.untilJqueryIsDone(driver);
		ini = System.currentTimeMillis();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	@When("^Seleccione origen$")
	public void seleccione_origen() throws Throwable {
		Select from = new Select(driver.findElement(By.name("fromPort")));

		from.selectByValue("Boston");

	}

	@And("^Seleccione destino$")
	public void seleccione_destino() throws Throwable {
		Select to = new Select(driver.findElement(By.name("toPort")));

		to.selectByValue("Rome");
	}

	@Then("^Pulsamos el boton y pasamos a buscar vuelos$")
	public void pulsamos_el_boton_y_pasamos_a_buscar_vuelos() throws Throwable {
		WebElement btn = driver.findElement(By.xpath("/html/body/div[3]/form/div/input"));

		btn.submit();
	}

	@Given("^Verificar que estamos en la pagina de seleccion de vuelo$")
	public void verificar_que_estamos_en_la_pagina_de_seleccion_de_vuelo() throws Throwable {
		JQueryWait.untilJqueryIsDone(driver);

		Assert.assertEquals("http://blazedemo.com/reserve.php", driver.getCurrentUrl());
	}

	@When("^Seleccionamos un vuelo$")
	public void seleccionamos_un_vuelo() throws Throwable {
		WebElement chooseFlight = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]/input"));

		chooseFlight.click();
	}

	@Given("^Verificar que estamos en la pagina informacion personal$")
	public void verificar_que_estamos_en_la_pagina_informacion_personal() throws Throwable {
		JQueryWait.untilJqueryIsDone(driver);

		Assert.assertEquals("http://blazedemo.com/purchase.php", driver.getCurrentUrl());
	}

	@When("^Rellenamos nuestros datos personales$")
	public void rellenamos_nuestros_datos_personales() throws Throwable {
		Cliente clientePrueba = FileReaderManager.getInstance().getJsonReader().getClientName("Luis");

		// name input
		driver.findElement(By.id("inputName")).sendKeys(clientePrueba.getNombre());

		// address input
		driver.findElement(By.id("address")).sendKeys(clientePrueba.getDireccion());

		// state input
		driver.findElement(By.id("city")).sendKeys(clientePrueba.getCiudad());

		// state input
		driver.findElement(By.id("state")).sendKeys(clientePrueba.getEstado());

		// zip code input
		driver.findElement(By.id("zipCode")).sendKeys(clientePrueba.getCodigoPostal());

		// card number input
		driver.findElement(By.id("creditCardNumber")).sendKeys(clientePrueba.getNumeroTarjeta());

		// month input
		driver.findElement(By.id("creditCardMonth")).sendKeys(clientePrueba.getMesCaducidadTarjeta());

		// year input
		driver.findElement(By.id("creditCardYear")).sendKeys(clientePrueba.getAnyoCaducidadTarjeta());

		// name on card input
		driver.findElement(By.id("nameOnCard")).sendKeys(clientePrueba.getNombreUsuarioTarjeta());

		// checkbox input
		WebElement checkbox = driver.findElement(By.id("rememberMe"));

		if (!checkbox.isEnabled()) {
			checkbox.click();
		}
	}

	@Then("^Pulsamos el boton para confirmar la compra$")
	public void pulsamos_el_boton_para_confirmar_la_compra() throws Throwable {

		driver.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();
	}

	@Then("^Cerramos el driver$")
	public void cerramos_el_driver() throws Throwable {
		driver.close();
		driver.quit();
		long fin =  System.currentTimeMillis() - ini;
		System.out.println("FIN DEL TEST " +fin+"s");
	}
	
	
}
