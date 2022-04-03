package com.example.apirestconspringboot.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
