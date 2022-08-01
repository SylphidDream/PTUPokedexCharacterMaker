package com.sylphid.ptupokedexcharactermaker.view

import androidx.fragment.app.Fragment
import com.sylphid.ptupokedexcharactermaker.di.DI

open class ViewModelFragment: Fragment() {
    protected val viewModel by lazy{
        DI.provideViewModel(requireActivity())
    }
}