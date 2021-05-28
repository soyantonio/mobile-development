//
//  ContentView.swift
//  LiveListProject
//
//  Created by Jesús Antonio Pérez Reyes on 06/05/21.
//

import SwiftUI

struct ContentView: View {
//    static var countryController = CountryController()
//    @State var countries: [CountryModel] = countryController.countries;
    //@StateObject var countryController = CountryController()
    @ObservedObject var countryController = CountryController()


    var body: some View {
        NavigationView {
//            List(countryController.countries) { country in
//                NavigationLink(destination: DetailView(country: country)){
//                    Text(country.name)
//                }
//            }
            List {
                ForEach(countryController.countries) { country in
                    NavigationLink(destination: DetailView(country: country)){
                        Text(country.name)
                    }
                }.onDelete(perform: deleteItem)
            }
            .navigationBarTitle("Countries", displayMode: .inline)
            .navigationBarItems(
//                trailing: NavigationLink(destination: AddCountryView(countries: $countries)){
                    trailing: NavigationLink(destination: AddCountryView(countryController: countryController)){
                    Image(systemName: "plus").foregroundColor(.blue)
                }
            )
    //      .navigationTitle("Countries")
        }
    }

    private func deleteItem(at IndexSet: IndexSet) {
        countryController.countries.remove(atOffsets: IndexSet)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

