//
//  AddCountryView.swift
//  LiveListProject
//
//  Created by Jesús Antonio Pérez Reyes on 13/05/21.
//

import SwiftUI

struct AddCountryView: View {
//    @Binding var countries: [CountryModel]
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>
    @ObservedObject var countryController: CountryController
    @State var countryName: String = ""
    @State var population: String = ""


    var body: some View {
        VStack{
            Text("Please Add a new country with the population")
                    .font(.title2)
                    .multilineTextAlignment(.center)
                    .padding(.bottom, 20)
            HStack {
                Image(systemName: "pencil.circle")
                        .foregroundColor(.gray)
                TextField("Country", text: $countryName)
            }
            .padding()
            .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color.blue, lineWidth: 1.0))
            HStack {
                Image(systemName: "person.3")
                        .foregroundColor(.gray)
                TextField("Population", text: $population)
            }
            .padding()
            .overlay(RoundedRectangle(cornerRadius: 10).stroke(Color.blue, lineWidth: 1.0))

            HStack {
                Button("Cancel") {
                    presentationMode.wrappedValue.dismiss()
                }
                .padding(.all)
                        .padding(.horizontal)
                        .foregroundColor(.white)
                        .background(Color.blue)
                        .cornerRadius(7.0)

                Button(action: {
//                    countries.append(CountryModel(id: UUID(), name: countryName, population: population))
                    countryController.addCountry(country: CountryModel(id: UUID(), name: countryName, population: population))
                    presentationMode.wrappedValue.dismiss()
                }) {
                    Text("Add country")
                }.padding(.all).foregroundColor(.white).background(Color.blue).cornerRadius(7.0)
            }.padding(.top)
        }
        .padding(.horizontal, 10)
        .navigationBarTitle("Add a new country")
    }
}

struct AddCountryView_Previews: PreviewProvider {
    @State static var data: [CountryModel] = [
        CountryModel(id: UUID(), name: "Mexico", population: "128M"),
        CountryModel(id: UUID(), name: "Canada", population: "37M"),
    ]
    static var countryController = CountryController()

    static var previews: some View {
        AddCountryView(countryController: countryController)
//        AddCountryView(countries: $data)
    }
}
