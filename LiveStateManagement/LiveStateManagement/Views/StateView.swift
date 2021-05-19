//
// Created by Jesús Antonio Pérez Reyes on 18/05/21.
//

import SwiftUI


struct StateView: View {
    var state: Binding<String>
    var body: some View {
        TextField("Hola", text: state)
    }
}
