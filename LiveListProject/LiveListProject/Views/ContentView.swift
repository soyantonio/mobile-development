//
//  ContentView.swift
//  LiveListProject
//
//  Created by Jesús Antonio Pérez Reyes on 06/05/21.
//

import SwiftUI

struct ContentView: View {
    var countryController = CountryController()
    
    var body: some View {
        NavigationView {
            List(countryController.countries) { country in
                NavigationLink(destination: DetailView(country: country)){
                    Text(country.name)
                }
            }
            .navigationBarTitle("Countries", displayMode: .inline)
            .navigationBarItems(
                trailing: NavigationLink(destination: AddCountryView(cityName: "")){
                    Image(systemName: "plus").foregroundColor(.blue)
                }
            )
    //      .navigationTitle("Countries")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

