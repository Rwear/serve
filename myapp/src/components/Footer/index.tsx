import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import { useIntl } from '@umijs/max';
import React from 'react';
import {CHATGPT, GITHUB} from "@/constants";

const Footer: React.FC = () => {
  const intl = useIntl();
  const defaultMessage = intl.formatMessage({
    id: 'app.copyright.produced',
    defaultMessage: 'Rwear',
  });

  const currentYear = new Date().getFullYear();

  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'planet',
          title: 'chatgpt',
          href: CHATGPT,
          blankTarget: true,
        },
        {
          key: 'block',
          title: 'deepL',
          href: 'https://www.deepl.com/en/translator',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <><GithubOutlined /> Rwear GitHub</>,
          href: GITHUB,
          blankTarget: true,
        },

      ]}
    />
  );
};

export default Footer;
