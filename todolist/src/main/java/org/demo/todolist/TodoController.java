package org.demo.todolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.demo.todolist.domain.Punkt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {
	
    @Autowired
    private ITodoRepository todoService;

    @GetMapping(value="/")
    public ModelAndView index() {
        var params = new HashMap<String, Object>();
        params.put("brukere", todoService.findAllBrukere());
        return new ModelAndView("index", params);
    }
    
    @GetMapping(value="/bruker")
    public ModelAndView getLister(@RequestParam long bruker_id) {
        var params = new HashMap<String, Object>();
        params.put("bruker", todoService.getBruker(bruker_id));
        params.put("lister", todoService.getLister(bruker_id));
        return new ModelAndView("bruker", params);
    }

    @GetMapping(value="/liste")
    public ModelAndView getListe(
    		@RequestParam long liste_id, 
    		@RequestParam(required = false, defaultValue = "") String punkt_id,
    		@RequestParam(required = false, defaultValue = "") String filter,
    		@RequestParam(required = false, defaultValue = "") String add,
    		@RequestParam(required = false, defaultValue = "") String action
    		) {
        var params = new HashMap<String, Object>();
        if(!add.isEmpty()) {
        	todoService.insertPunkt(liste_id,add);
        }
        switch(action) {
        case "del":
        	todoService.deletePunkt(liste_id,Integer.parseInt(punkt_id));
        case "duplikater":
        	HashSet<String> unike=new HashSet<>();
            for (Punkt punkt : todoService.getPunkter(liste_id)) {
				String tekst = punkt.getTekst();
				if(unike.contains(tekst)) {
		        	todoService.deletePunkt(liste_id,punkt.getPunkt_id());
				} else {
					unike.add(tekst);
				}
			}
        	break;
        	default:
        }
        params.put("liste", todoService.getListe(liste_id));
        List<Punkt> punkter = todoService.getPunkter(liste_id);
        List<Punkt> filtered=new ArrayList<>();
		String search = filter.toLowerCase();
        for (Punkt punkt : punkter) {
			if(filter.isEmpty() || 
					punkt.getTekst().toLowerCase().contains(search) ||
					punkt.getKategorier().toLowerCase().contains(search))
				filtered.add(punkt);
		}
		params.put("punkter", filtered);
		params.put("filter", filter);
        return new ModelAndView("liste", params);
    }

    @GetMapping(value="/punkt")
    public ModelAndView getPunkt(
    		@RequestParam long liste_id, 
    		@RequestParam long punkt_id,
    		@RequestParam(required = false, defaultValue = "") String tekst,
    		@RequestParam(required = false, defaultValue = "") String add,
    		@RequestParam(required = false, defaultValue = "") String del
    		) {
        Punkt punkt = todoService.getPunkt(liste_id, punkt_id);
		List<String> kats = new ArrayList<>(Arrays.asList(punkt.getKategorier().split(",")));
		kats.remove("");
        boolean save = false;
        if(!del.isEmpty()) {
    		kats.remove(del);
    		punkt.setKategorier(String.join(",", kats));
    		save=true;
        } else if(!add.isEmpty()) {
    		if(!kats.contains(add))
    			kats.add(add);
    		punkt.setKategorier(String.join(",", kats));
    		save=true;
        } else if(!tekst.isEmpty()) {
        	punkt.setTekst(tekst);
    		save=true;
        }
        if(save) {
        	todoService.updatePunkt(punkt);
        }
        var params = new HashMap<String, Object>();
        params.put("liste", todoService.getListe(liste_id));
		params.put("punkt", punkt);
		params.put("kategorier", kats);
        return new ModelAndView("punkt", params);
    }

}