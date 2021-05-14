//
//  ContentView.swift
//  GitHubTest
//
//  Created by Jesús Antonio Pérez Reyes on 13/05/21.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack{
            Text("Hello, world!")
                .padding()
            Button(action: {}, label: {
                Text("Button")
            })
            ProgressView(value: 0.54)
        }

    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
