package com.example.buensaborback.business.mapper;

import com.example.buensaborback.domain.dto.Factura.FacturaCreateDto;
import com.example.buensaborback.domain.dto.Factura.FacturaDto;
import com.example.buensaborback.domain.entities.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-11T01:06:38-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.4.1 (Eclipse Adoptium)"
)
@Component
public class FacturaMapperImpl implements FacturaMapper {

    @Override
    public FacturaDto toDTO(Factura source) {
        if ( source == null ) {
            return null;
        }

        FacturaDto facturaDto = new FacturaDto();

        facturaDto.setId( source.getId() );
        if ( source.isEliminado() != null ) {
            facturaDto.setEliminado( source.isEliminado() );
        }
        facturaDto.setFechaFcturacion( source.getFechaFcturacion() );
        facturaDto.setMpPaymentId( source.getMpPaymentId() );
        facturaDto.setMpMerchantOrderId( source.getMpMerchantOrderId() );
        facturaDto.setMpPreferenceId( source.getMpPreferenceId() );
        facturaDto.setMpPaymentType( source.getMpPaymentType() );
        facturaDto.setFormaPago( source.getFormaPago() );
        facturaDto.setTotalVenta( source.getTotalVenta() );

        return facturaDto;
    }

    @Override
    public Factura toEntity(FacturaDto source) {
        if ( source == null ) {
            return null;
        }

        Factura.FacturaBuilder<?, ?> factura = Factura.builder();

        factura.id( source.getId() );
        factura.eliminado( source.isEliminado() );
        factura.fechaFcturacion( source.getFechaFcturacion() );
        factura.mpPaymentId( source.getMpPaymentId() );
        factura.mpMerchantOrderId( source.getMpMerchantOrderId() );
        factura.mpPreferenceId( source.getMpPreferenceId() );
        factura.mpPaymentType( source.getMpPaymentType() );
        factura.formaPago( source.getFormaPago() );
        factura.totalVenta( source.getTotalVenta() );

        return factura.build();
    }

    @Override
    public Factura toEntityCreate(FacturaCreateDto source) {
        if ( source == null ) {
            return null;
        }

        Factura.FacturaBuilder<?, ?> factura = Factura.builder();

        factura.id( source.getId() );
        factura.eliminado( source.isEliminado() );
        factura.fechaFcturacion( source.getFechaFcturacion() );
        factura.mpPaymentId( source.getMpPaymentId() );
        factura.mpMerchantOrderId( source.getMpMerchantOrderId() );
        factura.mpPreferenceId( source.getMpPreferenceId() );
        factura.mpPaymentType( source.getMpPaymentType() );
        factura.formaPago( source.getFormaPago() );
        factura.totalVenta( source.getTotalVenta() );

        return factura.build();
    }

    @Override
    public Factura toUpdate(Factura entity, FacturaCreateDto source) {
        if ( source == null ) {
            return entity;
        }

        entity.setId( source.getId() );
        entity.setEliminado( source.isEliminado() );
        entity.setFechaFcturacion( source.getFechaFcturacion() );
        entity.setMpPaymentId( source.getMpPaymentId() );
        entity.setMpMerchantOrderId( source.getMpMerchantOrderId() );
        entity.setMpPreferenceId( source.getMpPreferenceId() );
        entity.setMpPaymentType( source.getMpPaymentType() );
        entity.setFormaPago( source.getFormaPago() );
        entity.setTotalVenta( source.getTotalVenta() );

        return entity;
    }

    @Override
    public List<FacturaDto> toDTOsList(List<Factura> source) {
        if ( source == null ) {
            return null;
        }

        List<FacturaDto> list = new ArrayList<FacturaDto>( source.size() );
        for ( Factura factura : source ) {
            list.add( toDTO( factura ) );
        }

        return list;
    }
}
