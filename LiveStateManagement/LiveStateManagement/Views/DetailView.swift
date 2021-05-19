//
//  DetailView.swift
//  LiveStateManagement
//
//  Created by Jesús Antonio Pérez Reyes on 18/05/21.
//
//

import SwiftUI

struct DetailView: View {
    @Binding var state: String

    var body: some View {
        TextField("Placeholder", text: $state)
        Text(state)
    }
}

struct DetailView_Previews: PreviewProvider {
    static var previews: some View {
        DetailView(state: .constant("Hola"))
    }
}
