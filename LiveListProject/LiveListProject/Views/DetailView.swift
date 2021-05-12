//
//  DetailView.swift
//  LiveListProject
//
//  Created by Jesús Antonio Pérez Reyes on 11/05/21.
//

import SwiftUI

struct DetailView: View {
    let country: CountryModel
    
    var body: some View {
        Text(country.name + " -> " + country.population)
    }
}


struct DetailView_Previews: PreviewProvider {
    static var previews: some View {
        DetailView(country: CountryModel(id: UUID(), name: "Mexico", population: "128M"))
    }
}
