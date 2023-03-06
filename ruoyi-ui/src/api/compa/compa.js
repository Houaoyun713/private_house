import request from '@/utils/request'

// 查询公司维护列表
export function listCompa(query) {
  return request({
    url: '/compa/compa/list',
    method: 'get',
    params: query
  })
}

// 查询公司维护详细
export function getCompa(id) {
  return request({
    url: '/compa/compa/' + id,
    method: 'get'
  })
}

// 新增公司维护
export function addCompa(data) {
  return request({
    url: '/compa/compa',
    method: 'post',
    data: data
  })
}

// 修改公司维护
export function updateCompa(data) {
  return request({
    url: '/compa/compa',
    method: 'put',
    data: data
  })
}

// 删除公司维护
export function delCompa(id) {
  return request({
    url: '/compa/compa/' + id,
    method: 'delete'
  })
}
