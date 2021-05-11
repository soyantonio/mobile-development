//
//  CountryController.swift
//  LiveListProject
//
//  Created by Jesús Antonio Pérez Reyes on 06/05/21.
//

import Foundation

class CountryController {
 
    var countries: [CountryModel]
    
    init(){
        self.countries = [
            CountryModel(id: UUID(), name: "Mexico", population: "128M"),
            CountryModel(id: UUID(), name: "Canada", population: "37M"),
            CountryModel(id: UUID(), name: "France", population: "67M"),
            CountryModel(id: UUID(), name: "Italy", population: "60M"),
            CountryModel(id: UUID(), name: "China", population: "1.38B"),
        ]
    }
    
    
}

