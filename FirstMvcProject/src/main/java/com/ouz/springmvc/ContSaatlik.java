package com.ouz.springmvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ContSaatlik {
	private static String[] Iller = {
			"","Adana", "Adiyaman", "Afyon", "Agri", "Amasya", "Ankara", "Antalya", "Artvin",
			"Aydin", "Balikesir", "Bilecik", "Bingol", "Bitlis", "Bolu", "Burdur", "Bursa", "Canakkale",
			"Cankiri", "Corum", "Denizli", "Diyarbakir", "Edirne", "Elazig", "Erzincan", "Erzurum", "Eskisehir",
			"Gaziantep", "Giresun", "Gumushane", "Hakkari", "Hatay", "Isparta", "Mersin", "Istanbul", "Izmir", 
			"Kars", "Kastamonu", "Kayseri", "Kirklareli", "Kirsehir", "Kocaeli", "Konya", "Kutahya", "Malatya", 
			"Manisa", "Kahramanmaras", "Mardin", "Mugla", "Mus", "Nevsehir", "Nigde", "Ordu", "Rize", "Sakarya",
			"Samsun", "Siirt", "Sinop", "Sivas", "Tekirdag", "Tokat", "Trabzon", "Tunceli", "Sanliurfa", "Usak",
			"Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kirikkale", "Batman", "Sirnak",
			"Bartin", "Ardahan", "Igdir", "Yalova", "Karabuk", "Kilis", "Osmaniye", "Duzce"
	};
	
	@RequestMapping(value = {"/", "/saatlik"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model, @RequestParam(value = "il", required = false) String il) {
		if(il == null || il == "") {
			il = "Kocaeli";
		}
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		ResponseEntity<ModelIl[]> result = restTemplate.getForEntity(
					"http://212.175.180.28/api/merkezler?il=" + il, 
					ModelIl[].class);
		ModelIl ilBilgisi = result.getBody()[0];
		
		ResponseEntity<ModelSaatlik[]> result2 = restTemplate.getForEntity(
					"http://212.175.180.28/api/tahminler/saatlik?istno=" + ilBilgisi.getSaatlikTahminIstNo(), 
					ModelSaatlik[].class);
		ModelSaatlik saatlikHavaBilgisi = result2.getBody()[0];

		model.addAttribute("ilListesi", Iller);
		model.addAttribute("ilBilgisi", ilBilgisi);
		model.addAttribute("saatlikHavaBilgisi", saatlikHavaBilgisi);
		return "saatlik";
	}
	
}
