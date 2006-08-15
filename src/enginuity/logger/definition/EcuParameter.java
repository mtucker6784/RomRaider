package enginuity.logger.definition;

import enginuity.logger.definition.convertor.EcuParameterConvertor;

public interface EcuParameter {

    String getName();

    String getDescription();

    String[] getAddresses();

    EcuParameterConvertor getConvertor();

}