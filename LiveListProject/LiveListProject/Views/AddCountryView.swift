//
//  AddCountryView.swift
//  LiveListProject
//
//  Created by Jesús Antonio Pérez Reyes on 13/05/21.
//

import SwiftUI

struct AddCountryView: View {
    @State var cityName: String
    var body: some View {
        VStack{
            TextField("Add a city name", text: $cityName)
            Text(cityName)
            Button(action: {}, label: {
                /*@START_MENU_TOKEN@*/Text("Button")/*@END_MENU_TOKEN@*/
            })
        }
        .navigationBarTitle("Add a new country")
    }
}

struct AddCountryView_Previews: PreviewProvider {
    static var previews: some View {
        AddCountryView(cityName: "")
    }
}
