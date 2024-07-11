package com.example.exam.customNav

enum class FragmentType{
    HOME,CATEGORY,BASKET,PROFILE
}

interface ActiveFragment{

    fun setFragmentType(type: FragmentType)

}