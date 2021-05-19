//
//  ContentView.swift
//  LiveStateManagement
//
//  Created by Jesús Antonio Pérez Reyes on 18/05/21.
//

import SwiftUI

struct ContentView: View {
    @State var state: String
    var body: some View {
        NavigationView {
            VStack {
                TextField("Placeholder", text: $state)
                StateView(state: $state)
                AlternativeView(state: $state)
                Text(state)
                NavigationLink(destination: DetailView(state: $state)){
                    Text("Go to")
                }
            }
        }
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(state: "Something")
    }
}
